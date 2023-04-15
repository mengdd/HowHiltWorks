package com.ddmeng.howhiltworks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ddmeng.howhiltworks.ui.theme.HowHiltWorksTheme
import com.ddmeng.mylibrary.SecondActivity
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var analytics: AnalyticsAdapter

    @LocalSource
    @Inject
    lateinit var localSource: DataSource

    @RemoteSource
    @Inject
    lateinit var remoteSource: DataSource

    @Inject
    lateinit var tool: Tool

    @Inject
    lateinit var customComponentBuilder: CustomComponent.Builder

    @Inject
    @Flow2
    lateinit var factory1: Factory1

    @Inject
    @Flow2
    lateinit var factory2: Factory2

    private val viewModel: ExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HowHiltWorksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    viewModel.print()

                    val component = customComponentBuilder.sharedDependency(Config1("Test")).build()
                    Column {
                        Greeting("Android")
                        Greeting(EntryPoints.get(component, CustomEntryPoint::class.java).factory1().toString())
                        Greeting(EntryPoints.get(component, CustomEntryPoint::class.java).factory2().toString())
                        Greeting(factory1.toString())
                        Greeting(factory2.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Text(text = "Hello $name!",
        Modifier.clickable {
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HowHiltWorksTheme {
        Greeting("Android")
    }
}
