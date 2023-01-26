package andres.rangel.dictionary.feature_dictionary.presentation

import andres.rangel.dictionary.feature_dictionary.domain.model.WordInfo
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WordInfoItem(
    modifier: Modifier = Modifier,
    wordInfo: WordInfo
) {
    Column(modifier = modifier) {
        Text(
            text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = wordInfo.phonetic,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(16.dp))
        wordInfo.meanings.forEach { meaning ->
            Text(
                text = meaning.partOfSpeech,
                fontWeight = FontWeight.Bold
            )
            meaning.definitions.forEachIndexed { index, definition ->
                Text(text = "${index + 1}. ${definition.definition}")
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let {
                    Text(text = "Example: $it")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}