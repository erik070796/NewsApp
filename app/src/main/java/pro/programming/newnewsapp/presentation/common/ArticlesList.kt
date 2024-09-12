package pro.programming.newnewsapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import pro.programming.newnewsapp.domain.model.Article
import pro.programming.newnewsapp.presentation.Dimens.ExtraSmallPadding2
import pro.programming.newnewsapp.presentation.Dimens.mediumPadding1


@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    article: List<Article>,
    onClick: (Article) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(mediumPadding1),
        contentPadding = PaddingValues(ExtraSmallPadding2)
    ) {
        items(article.size) {
            val articles = article[it]
            ArticleCard(article = articles, onClick = { onClick(articles) })
        }
    }
}


@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    article: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(article)
    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(mediumPadding1),
            contentPadding = PaddingValues(ExtraSmallPadding2)
        ) {
            items(article.itemCount) {
                article[it]?.let {
                    ArticleCard(article = it, onClick = { onClick(it) })
                }
            }
        }
    }
}


@Composable
fun handlePagingResult(
    article: LazyPagingItems<Article>
): Boolean {

    val loadState = article.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }
    }

}

@Composable
private fun ShimmerEffect() {

    Column(verticalArrangement = Arrangement.spacedBy(mediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(mediumPadding1)
            )
        }
    }
}