package pro.programming.newnewsapp.domain.usecases.news

import kotlinx.coroutines.flow.Flow
import pro.programming.newnewsapp.data.local.NewsDao
import pro.programming.newnewsapp.domain.model.Article
import pro.programming.newnewsapp.domain.repository.NewsRepository

class SelectArticle(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }

}