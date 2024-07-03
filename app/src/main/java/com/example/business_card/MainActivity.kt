package com.example.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.business_card.ui.theme.Business_CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Business_CardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeCardContactDetails(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TypeOfContact(modifier: Modifier = Modifier, contactType: String) {
    Text( text = contactType, modifier = Modifier.width(20.dp))
}

@Composable
fun ComposeCardContactDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier

        ) {
            TypeOfContact(contactType = "t:", modifier = modifier)
            Text("0789667 12344")
        }
        Row(
            modifier = modifier,

            ) {
            TypeOfContact(contactType = "e:", modifier = modifier)
            Text("faisal@android.com")
        }
        Row(
            modifier = modifier,

            ) {
            TypeOfContact(contactType = "w:", modifier = modifier)
            Text("github.com/faisalmemon")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ContactDetailPreview() {
    Business_CardTheme {
        ComposeCardContactDetails()
    }
}