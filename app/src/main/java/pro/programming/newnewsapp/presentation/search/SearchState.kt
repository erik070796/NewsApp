package pro.programming.newnewsapp.presentation.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import pro.programming.newnewsapp.domain.model.Article
import retrofit2.http.Query

data class SearchState(
    val searchQuery: String,
    val articles :Flow<PagingData<Article>>? = null
) {
}