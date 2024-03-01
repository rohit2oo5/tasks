package com.myapplication

import android.content.Context
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.dataStore
import androidx.navigation.NavHostController
import com.myapplication.ui.theme.primaryBlue
import com.myapplication.ui.theme.secondaryBlue
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.setValue
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(context: Context, navController: NavController) {

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val dataStore = UserDetail(context)



    val userNameState = remember{
        mutableStateOf("")
    }

    val passwordState = remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    val scrollState = rememberScrollState()


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(primaryBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth(.2f)
            .padding(top = 30.dp)) {
            Text(text = "Tasks",
                color = Color.White,
                fontSize = 25.sp)
        }

        Row(modifier = Modifier
            .height(90.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "sign in",
                color = Color.White,
                fontSize = 15.sp)
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        Column(modifier = Modifier
            .fillMaxWidth(0.7f)) {
            
            Text(
                text = "User Name",
                color = Color.White
            )
            
            OutlinedTextField(
                maxLines = 1,
                value = userNameState.value,
                onValueChange = { userNameState.value = it },
                label = { Text(text = "User Name") },
                colors = OutlinedTextFieldDefaults.
                colors(
                    focusedBorderColor = primaryBlue,
                    focusedLabelColor = primaryBlue,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )
            Spacer(modifier = Modifier
                .height(50.dp))
            Text(
                text = "Password",
                color = Color.White
            )

            OutlinedTextField(
                maxLines = 1,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        value = passwordState.value,
                onValueChange = {passwordState.value = it},
                label = { Text(text = "Password")},
                colors = OutlinedTextFieldDefaults.
                colors(
                    focusedBorderColor = primaryBlue,
                    focusedLabelColor = primaryBlue,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                    ),
                trailingIcon = {
                    val image = if (passwordVisible) {
                        Icons.Filled.Visibility
                    } else Icons.Filled.VisibilityOff


                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description )
                    }
                }
            )

            Spacer(modifier = Modifier.height(60.dp))

            Button(
                onClick = { scope.launch {
                    dataStore.saveUserName(userNameState.value)
                    dataStore.savePassword(passwordState.value)
                    }

                    navController.navigate(Home.route)
                 },
                colors = ButtonDefaults
                    .buttonColors(secondaryBlue),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Sign In")
            }

            Spacer(modifier = Modifier
                .height(50.dp))

            Text(
                text = "or",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Divider(thickness = 1.dp, color = Color.White)
            Spacer(modifier = Modifier.height(40.dp))


        }



    }
}


