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
import androidx.compose.ui.res.stringResource
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
            TypeOfContact(contactType = stringResource(id = R.string.contact_type_phone), modifier = modifier)
            Text(text = stringResource(id = R.string.phone_contact))
        }
        Row(
            modifier = modifier,
            ) {
            TypeOfContact(contactType = stringResource(id = R.string.contact_type_email), modifier = modifier)
            Text(text = stringResource(id = R.string.email_contact))
        }
        Row(
            modifier = modifier,
            ) {
            TypeOfContact(contactType = stringResource(id = R.string.contact_type_web), modifier = modifier)
            Text(text = stringResource(id = R.string.web_contact))
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