package pro.programming.newnewsapp.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import pro.programming.newnewsapp.R
import pro.programming.newnewsapp.domain.model.Article
import pro.programming.newnewsapp.presentation.Dimens.mediumPadding1
import pro.programming.newnewsapp.presentation.common.ArticlesList
import pro.programming.newnewsapp.presentation.navgraph.Route

@Composable
fun BookmarkScreen(
    state: BookmarkState,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = mediumPadding1, start = mediumPadding1, end = mediumPadding1)
    ) {
        Text(
            text = "bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(R.color.text_title)
        )

        Spacer(Modifier.height(mediumPadding1))

        ArticlesList(article = state.articles, onClick = {
            navigateToDetails(it)
        }
        )
    }
}