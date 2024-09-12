package pro.programming.newnewsapp.data.remote.dto

import pro.programming.newnewsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)