package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import com.hhplus.board.db.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    val articleRepository: ArticleRepository,
    private val userService: UserService
) {
    fun getArticleList(): ArticleListGetResult {
        val articleEntities: List<ArticleEntity> = articleRepository.findAll()
        return ArticleListGetResult(ArticleGetListItemResult.fromArticleEntityList(articleEntities))
    }

    fun createArticle(articlePost: ArticlePost): ArticlePostResult {
        val articleAuthorId = articlePost.authorId
            ?: throw IllegalArgumentException("작성자 정보가 없습니다.")

        val articleAuthor = userService.findUserById(articleAuthorId)

        val articleEntity = articlePost.toArticleEntity(articleAuthor)
        val savedArticleEntity = articleRepository.save(articleEntity)
        return ArticlePostResult.fromArticleEntity(savedArticleEntity)
    }

    fun updateArticle(articlePut: ArticlePut): ArticlePutResult {
        val article =  articleRepository.findById(articlePut.id).orElseThrow { NoSuchElementException("게시글 없음") }

        val articleAuthor = userService.findUserById(articlePut.authorId)

        val updatedArticle = article.update(articlePut.title, articleAuthor, articlePut.content)
        return ArticlePutResult.fromArticleEntity(articleRepository.save(updatedArticle))
    }

    fun getArticle(id: Long): ArticleGetListItemResult {
        val article: ArticleEntity = articleRepository.findById(id).orElseThrow { NoSuchElementException("게시글 없음") }
        return ArticleGetListItemResult.fromArticleEntity(article)
    }

    fun deleteArticle(articleDelete: ArticleDelete) {
        val article: ArticleEntity = articleRepository.findById(articleDelete.id).orElseThrow { NoSuchElementException("게시글 없음") }

        userService.findUserById(articleDelete.authorId)

        articleRepository.delete(article)
    }
}
