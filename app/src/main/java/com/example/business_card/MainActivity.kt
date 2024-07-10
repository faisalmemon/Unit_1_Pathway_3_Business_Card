package com.example.business_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card.ui.theme.Business_CardTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Business_CardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier,
                 shape: RoundedCornerShape = RoundedCornerShape(50.dp)) {
    Row(modifier = modifier
        .padding(20.dp)
        .clip(shape)
        .background(color = colorResource(id = R.color.business_card_background_color))) {
        Spacer(modifier = modifier.width(30.dp))
        BusinessCardVerticalInterior(modifier = modifier)
    }
}

@Composable
fun BusinessCardVerticalInterior(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(3.dp)
    ) {
        Text(text = stringResource(id = R.string.full_name),
            fontFamily = FontFamily.Monospace,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(30.dp))

        Text(text = stringResource(id = R.string.job_role),
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.height(30.dp))
        Row {
            Spacer(modifier = modifier.width(70.dp))
            ComposeCardContactDetails(modifier = modifier)
        }
        Spacer(modifier = modifier.height(20.dp))

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
            modifier = modifier.padding(bottom = 10.dp)
        ) {
            TypeOfContact(contactType = stringResource(id = R.string.contact_type_phone))
            Text(text = stringResource(id = R.string.phone_contact),
                fontFamily = FontFamily.SansSerif)
        }
        Row(
            modifier = modifier.padding(bottom = 10.dp),
        ) {
            TypeOfContact(contactType = stringResource(id = R.string.contact_type_email))
            Text(text = stringResource(id = R.string.email_contact),
                fontFamily = FontFamily.SansSerif,
                modifier = modifier)
        }
        Row(
            modifier = modifier,
        ) {
            TypeOfContact(contactType = stringResource(id = R.string.contact_type_web), modifier = modifier.padding(bottom = 10.dp))
            Text(text = stringResource(id = R.string.web_contact),
                fontFamily = FontFamily.SansSerif,
                modifier = modifier)
        }
    }
}

@Composable
fun RoundedCornerShapeDemo(){
    ExampleBox(shape = RoundedCornerShape(10.dp))
}

@Composable
fun ExampleBox(shape: Shape){
    Column(modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier.size(100.dp).clip(shape).background(Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContactDetailPreview() {
    Business_CardTheme {
        BusinessCard()
    }
}