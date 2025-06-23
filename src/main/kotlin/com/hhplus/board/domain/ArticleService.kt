package com.hhplus.board.domain

import com.hhplus.board.db.ArticleEntity
import com.hhplus.board.db.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    val ArticleRepository: ArticleRepository
) {
    fun getArticles(article: Article, meta: ArticleGetMeta): ArticleGetResult {
//        val id: Long = meta.cursor
        val ArticleEntities: List<ArticleEntity> = ArticleRepository.findByIdLessThan(meta.cursor);
//        val
        return ArticleGetResult(, ArticleGetListItemResult.fromArticleEntity(ArticleEntities))
    }


    fun createArticle(): ArticleGetResult {
        val ArticleEntities: List<ArticleEntity> = ArticleRepository.findAll();

        return ArticleGetResult(ArticleGetListItemResult.fromArticleEntityList(ArticleEntities))
    }


}
