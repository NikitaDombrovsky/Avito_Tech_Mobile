package com.example.avito_mobile_dombrovskiy

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp_Test(viewModel: WeatherViewModel_ = viewModel()) {
    val weatherState by viewModel.state.collectAsState()
    var topBarCityName by remember { mutableStateOf("Саси") }
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Содержимое Drawer
            DrawerContent_(
                onItemClick = { route ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route)
                }
            )
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Погода в $topBarCityName") },
                        navigationIcon = {
                            IconButton(onClick = {*//* scope.launch { drawerState.open() }*//* }) {
                                Icon(Icons.Default.Search, contentDescription = "Меню")
                            }
                            *//*                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                                            Icon(Icons.Default.Menu, contentDescription = "Меню")
                                                        }*//*
                        }
                    )
                }
            ) { innerPadding ->
                when (weatherState) {
                    is WeatherState.Loading -> {
                        LoadingActivity(Modifier.padding(innerPadding))
                    }

                    is WeatherState.Success -> {
                        val weatherResponse = (weatherState as WeatherState.Success).weatherResponse
                        topBarCityName = weatherResponse.name
                        // Основное содержимое
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") { CurrentWeatherActivity(weatherResponse) }
                            composable("settings") { SettingsScreen() }
                            //  composable("profile") { ProfileScreen() }
                        }
                        //CurrentWeatherActivity(weatherResponse)

                    }

                    is WeatherState.Error -> {
                        val errorMessage = (weatherState as WeatherState.Error).message
                        ErrorActivity(errorMessage)
                    }


                }
            }
            viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")

        }
    )
}*/

/*@Preview
@Composable
private fun PreviewWeatherApp_TestSvipe() {
    WeatherApp_TestSvipe()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp_TestSvipe(viewModel: WeatherViewModel_ = viewModel()) {
    val weatherState by viewModel.state.collectAsState()
    var topBarCityName by remember { mutableStateOf("Саси") }
    val navController = rememberNavController()
    *//*    val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()*//*

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Погода в $topBarCityName") },
                navigationIcon = {
                    IconButton(onClick = {*//* scope.launch { drawerState.open() }*//* }) {
                        Icon(Icons.Default.Search, contentDescription = "Меню")
                    }
                }
            )
        }
    ) { innerPadding ->
        when (weatherState) {
            is WeatherUIState.Loading -> {
                LoadingActivity(Modifier.padding(innerPadding))
            }

            is WeatherUIState.Success -> {

                val weatherResponse = (weatherState as WeatherUIState.Success).weatherResponse
                topBarCityName = weatherResponse.name

                Column(modifier = Modifier.fillMaxSize()) {

                    Box(
                        modifier = Modifier

                            //.size(10.dp)
                            //.fillMaxSize()
                            .draggable(
                                state = rememberDraggableState { delta ->
                                    if (delta > 0) {
                                        navController.navigate("home")
                                    } else if (delta < 0) {
                                        navController.navigate("settings")
                                    }
                                },
                                orientation = Orientation.Horizontal
                            )
                    ) {
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                CurrentWeatherActivity(weatherResponse)

                            }
                            composable("settings") {
                                SecondScreen(navController)
                            }
                        }
                    }
                }
            }

            is WeatherUIState.Error -> {
                val errorMessage = (weatherState as WeatherUIState.Error).message
                ErrorActivity(errorMessage)
            }

            is WeatherUIState.WeeklySuccess -> TODO()
        }
    }
    viewModel.fetchWeather("Omsk", "4dfc05c3309bcd397630c1c51dda583b")


}*/

/*@Composable
private fun CurrentWeatherContent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                state = rememberDraggableState { delta ->
                    if (delta > 0) {
                        navController.navigate("home")
                    } else if (delta < 0) {
                        navController.navigate("settings")
                    }
                },
                orientation = Orientation.Horizontal
            )
    ) {

        NavHost(navController = navController, startDestination = "home") {
            composable("home") { CurrentWeatherActivity(weatherResponse)*//*HomeScreen(navController)*//* }
            composable("settings") { SettingsScreen(navController) }
        }
    }
}*/


/*@Composable
private fun CustomLinearProgressBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
        // .fillMaxSize()
        *//*            .fillMaxWidth()
                    .height(10.dp)*//*
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(MaterialTheme.colorScheme.error),
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(MaterialTheme.colorScheme.surfaceContainer)
        )
    }
}*/



/*@Composable
private fun CustomLinearProgressBar(){
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp),
            trackColor = Color.Red,
            //progress = 0.50f,
            color = MaterialTheme.colorScheme.background
            //backgroundColor = Color.LightGray,
           // color = Color.Red //progress color
        )
    }
}*/
/*@Composable
fun BottomNavSwipeScreen() {
    // This scope is necessary to change the tab using animation
    val scope = rememberCoroutineScope()
    // I'm using a list of images here
    val images = listOf(R.drawable.ic_launcher_background, R.drawable.weather_cloudy)
    // This page state will be used by BottomAppbar and HorizontalPager
    val pageState = rememberPagerState(pageCount = images.size)
    //val scaffoldState = rememberScaffoldState()
    Scaffold(
        //scaffoldState = scaffoldState,
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colorScheme.primary,
                content = {
                    for (page in images.indices) {
                        BottomNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Home, "Page $page")
                            },
                            // here's the trick. the selected tab is based
                            // on HorizontalPager state.
                            selected = page == pageState.currentPage,
                            onClick = {
                                // When a tab is selected,
                                // the page is updated
                                scope.launch {
                                    pageState.animateScrollToPage(page)
                                }
                            },
                            selectedContentColor = Color.Magenta,
                            unselectedContentColor = Color.LightGray,
                            label = { Text(text = "Page $page") }
                        )
                    }
                }
            )
        },
    ) {
        HorizontalPager(
            state = pageState,
            offscreenLimit = 2
        ) { page ->
            Image(
                painterResource(id = images[page]),
                null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}*/

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Мое приложение") }
            )
        }
    ) {  innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Horizontal
                )
        ) {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("settings") { SettingsScreen(navController) }
                composable("profile") { ProfileScreen(navController) }
            }
        }
    }
}*/



@Composable
fun SecondScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Настройки")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Перейти к профилю")
        }
    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Настройки")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Перейти к профилю")
        }
    }
}



/*@Composable
fun MyApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Содержимое Drawer
            DrawerContent(
                onItemClick = { route ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route)
                }
            )
        },
        content = {
            // Основное содержимое
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen() }
                composable("settings") { SettingsScreen() }
                composable("profile") { ProfileScreen() }
            }
        }
    )
}*/
@Composable
fun DrawerContent_(onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            //.background(MaterialTheme.colorScheme.onBackground)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Мое приложение",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
        )

        DrawerItem(
            text = "Главная",
            painter = painterResource(id = R.drawable.weather_cloudy),
            onClick = { onItemClick("home") })
        DrawerItem(
            text = "Настройки",
            painter = painterResource(id = R.drawable.weather_cloudy),
            onClick = { onItemClick("settings") })

    }
}

@Composable
fun DrawerItem(text: String, painter: Painter, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp)
    ) {
        Icon(painter = painter, contentDescription = text, tint = Color.Black)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 18.sp, color = Color.Black)
    }
}



/*
@Composable
fun HomeScreen() {
    Text(text = "Главная")
}
*/

@Composable
fun SettingsScreen() {
    Text(text = "Настройки")
}

/*
@Composable
fun ProfileScreen() {
    Text(text = "Профиль")
}*/
