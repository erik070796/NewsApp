package pro.programming.newnewsapp.domain.usecases.news

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pro.programming.newnewsapp.data.local.NewsDao
import pro.programming.newnewsapp.domain.model.Article
import pro.programming.newnewsapp.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article)= withContext(Dispatchers.IO) {
        newsRepository.deleteArticle(article)
    }
}