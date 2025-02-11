package pe.edu.ulima.pm20232.aulavirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.FormViewModel
import pe.edu.ulima.pm20232.aulavirtual.screens.LoginScreen
import pe.edu.ulima.pm20232.aulavirtual.screens.PasswordScreen
import pe.edu.ulima.pm20232.aulavirtual.screens.SplashScreen
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.AulaVirtualTheme

class MainActivity : ComponentActivity() {
    private val loginScreenViewModel by viewModels<FormViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AulaVirtualTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen {
                                navController.navigate("main")
                            }
                        }
                        composable("main") {
                            // Replace with your main screen Composable
                            PasswordScreen(loginScreenViewModel)
                            //LoginScreen(loginScreenViewModel)
                            //ProfileScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
