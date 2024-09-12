package pro.programming.newnewsapp.presentation.bookmark

import pro.programming.newnewsapp.domain.model.Article

data class BookmarkState (
    val articles : List<Article> = emptyList()
)