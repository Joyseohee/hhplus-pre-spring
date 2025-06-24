package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import com.hhplus.board.db.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    val articleRepository: ArticleRepository
) {
    fun getArticleList(): ArticleListGetResult {
        val articleEntities: List<ArticleEntity> = articleRepository.findAll()
        return ArticleListGetResult(ArticleGetListItemResult.fromArticleEntityList(articleEntities))
    }

    fun createArticle(articlePost: ArticlePost): ArticlePostResult {
        val articleEntity = ArticleEntity( articlePost.title, articlePost.author, articlePost.content, articlePost.password)
        val savedArticleEntity = articleRepository.save(articleEntity)
        return ArticlePostResult.fromArticleEntity(savedArticleEntity)
    }

    fun updateArticle(articlePut: ArticlePut): ArticlePutResult {
        val article =  articleRepository.findById(articlePut.id).orElseThrow { NoSuchElementException("게시글 없음") }
        val updatedArticle = article.update(articlePut.title, articlePut.author, articlePut.content, articlePut.password)
        return ArticlePutResult.fromArticleEntity(articleRepository.save(updatedArticle))
    }

    fun getArticle(id: Long): ArticleGetListItemResult {
        val article: ArticleEntity = articleRepository.findById(id).orElseThrow { NoSuchElementException("게시글 없음") }
        return ArticleGetListItemResult.fromArticleEntity(article)
    }

    fun deleteArticle(articleDelete: ArticleDelete) {
        val article: ArticleEntity = articleRepository.findById(articleDelete.id).orElseThrow { NoSuchElementException("게시글 없음") }
        article.verifyPassword(articleDelete.password)
        articleRepository.delete(article)
    }
}
