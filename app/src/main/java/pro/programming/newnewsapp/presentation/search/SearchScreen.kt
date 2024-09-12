package pro.programming.newnewsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import pro.programming.newnewsapp.domain.model.Article
import pro.programming.newnewsapp.presentation.Dimens.mediumPadding1
import pro.programming.newnewsapp.presentation.common.ArticlesList
import pro.programming.newnewsapp.presentation.common.SearchBar
import pro.programming.newnewsapp.presentation.navgraph.Route

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        Modifier
            .padding(
                top = mediumPadding1,
                start = mediumPadding1,
                end = mediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) })

        Spacer(Modifier.height(mediumPadding1))

        state.articles?.let {
            val articels = it.collectAsLazyPagingItems()

            ArticlesList(article = articels, onClick = {
                navigateToDetails(it)
            })
        }

    }

}