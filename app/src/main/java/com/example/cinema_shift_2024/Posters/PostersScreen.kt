package com.example.cinema_shift_2024.Posters

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cinema_shift_2024.R
import com.example.cinema_shift_2024.data.network.ApiFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun PostersScreen() {

    val scope = rememberCoroutineScope()
    var postersState by remember { mutableStateOf<PostersState>(PostersState.Initial) }

    val repository = ApiFactory()

    LaunchedEffect(Unit) {
        Log.d("Posters Screen", "Launched")
        loadFilms(repository, setPostersState = { postersState = it })

    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.posters_title))

        when (val state = postersState) {
            is PostersState.Initial,
            is PostersState.Loading -> LoadingComponent()

            is PostersState.Content -> ContentComponent(state.films, { })
            is PostersState.Failure -> ErrorComponent(state.message) {
                Log.d("Posters Screen", "Click on retry")
                scope.loadFilms(repository, setPostersState = { postersState = it })
            }
        }
    }
}

private fun CoroutineScope.loadFilms(
    repository: ApiFactory,
    setPostersState: (PostersState) -> Unit,
) {
    launch {
        setPostersState(PostersState.Loading)

        try {
            val filmsResponse = repository.getFilms()
            Log.d("Posters Screen", filmsResponse.toString())
            setPostersState(PostersState.Content(filmsResponse.films))
        } catch (ce: CancellationException) {
            throw ce
        } catch (ex: Exception) {
            setPostersState(PostersState.Failure(ex.message.orEmpty()))
        }
    }
}
