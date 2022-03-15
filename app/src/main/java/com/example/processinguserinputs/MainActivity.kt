package com.example.processinguserinputs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.processinguserinputs.ui.theme.ProcessingUserInputsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProcessingUserInputsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    textFieldExample()
                }
            }
        }
    }
}

fun Login(user_name:String,password:String):String
{
    var status:String=""

    if(user_name.equals("mayur")&&password
            .equals("dharukiya"))
    {
        status="Login Successful"
    }
    else
    {
        status="Login UnSuccessful"
    }

    return status
}
@Composable
fun textFieldExample()
{
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .border(1.dp, Color.Red, RectangleShape)



    )
    {

        var username by rememberSaveable {mutableStateOf("") }
        var password by rememberSaveable {mutableStateOf("") }


        TextField(value = username,
            onValueChange ={username=it},
            label = {Text("User Name:")}
        )

        TextField(value = password,
            onValueChange ={password=it},
            label = {Text("Password:")}
        )
        var status by rememberSaveable {
             mutableStateOf("") }
        Button(onClick = {status= Login(username,password) }) {


            Text(text = "$status")
        }




    }

}
