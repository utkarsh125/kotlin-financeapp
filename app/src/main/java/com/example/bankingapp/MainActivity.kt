package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedapps.bankningappui.CurrenciesSection
import com.example.bankingapp.ui.theme.BankingAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingAppTheme {

                //a surface container using the 'background' color from the theme
                SetBarColor(color = MaterialTheme.colorScheme.background)

               Surface (
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ){

                   HomeScreen()

               }
            }
        }
    }

    @Composable
    private fun SetBarColor(color: Color){
        //create a value that changes that color
        var systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun HomeScreen(){
    Scaffold (
        bottomBar = {

            BottomNavigationBar()

        }
    ) {padding ->

        Column (
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {

            //first section - Wallet Section

            WalletSection()
            CardSection()

            Spacer(modifier = Modifier.height(16.dp))

            FinanceSection()
            CurrenciesSection()
        }

    }
}
