package pro.programming.newnewsapp.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import pro.programming.newnewsapp.domain.model.Article
import pro.programming.newnewsapp.domain.repository.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}