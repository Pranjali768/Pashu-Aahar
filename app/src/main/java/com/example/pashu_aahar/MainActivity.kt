package com.example.pashu_aahar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pashu_aahar.ui.theme.PashuaaharTheme

enum class AppLanguage { EN, HI, MR }

data class AppStrings(
    val title: String,
    val subtitle: String,
    val startBtn: String,
    val cow: String,
    val feed: String,
    val cost: String,
    val tips: String,
    val breed: String,
    val weight: String,
    val age: String,
    val milkYield: String,
    val generateRecipe: String,
    val recipeTitle: String,
    val dailyRecipe: String,
    val monthlySavings: String,
    val costComparison: String,
    val homemade: String,
    val market: String,
    val savings: String,
    val whyThisMix: String,
    val backToHome: String,
    val hygiene: String,
    val hygieneDesc: String,
    val storage: String,
    val storageDesc: String,
    val watering: String,
    val wateringDesc: String,
    val impactGoal: String,
    val impactGoalDesc: String
)

val translations = mapOf(
    AppLanguage.EN to AppStrings(
        title = "Pashu Aahar",
        subtitle = "Smart Nutrition for Healthy Cattle",
        startBtn = "Start Calculation",
        cow = "Cow",
        feed = "Feed",
        cost = "Cost",
        tips = "Knowledge Base",
        breed = "Breed",
        weight = "Weight (kg)",
        age = "Age (Years)",
        milkYield = "Milk Yield (L/Day)",
        generateRecipe = "Generate Recipe",
        recipeTitle = "Nutrition Recipe",
        dailyRecipe = "Daily Feed Mix",
        monthlySavings = "Monthly Savings",
        costComparison = "Cost Comparison",
        homemade = "Homemade Feed",
        market = "Market Feed",
        savings = "Daily Savings",
        whyThisMix = "Veterinary Knowledge Base",
        backToHome = "Back to Home",
        hygiene = "Hygiene",
        hygieneDesc = "Keep the shed clean and dry to prevent diseases.",
        storage = "Grain Storage",
        storageDesc = "Store feed in a dry place away from moisture and pests.",
        watering = "Watering",
        wateringDesc = "Ensure 24/7 access to fresh, clean drinking water.",
        impactGoal = "Impact Goal",
        impactGoalDesc = "Empowering farmers with scientific nutrition for better livelihood."
    ),
    AppLanguage.HI to AppStrings(
        title = "पशु आहार",
        subtitle = "स्वस्थ पशुओं के लिए स्मार्ट पोषण",
        startBtn = "गणना शुरू करें",
        cow = "गाय",
        feed = "आहार",
        cost = "लागत",
        tips = "ज्ञान केंद्र",
        breed = "नस्ल",
        weight = "वजन (किलो)",
        age = "आयु (वर्ष)",
        milkYield = "दूध की मात्रा (लीटर/दिन)",
        generateRecipe = "रेसिपी बनाएं",
        recipeTitle = "पोषण रेसिपी",
        dailyRecipe = "दैनिक आहार मिश्रण",
        monthlySavings = "मासिक बचत",
        costComparison = "लागत तुलना",
        homemade = "घर का बना आहार",
        market = "बाजार का आहार",
        savings = "दैनिक बचत",
        whyThisMix = "पशु चिकित्सा ज्ञान आधार",
        backToHome = "मुख्य पृष्ठ",
        hygiene = "स्वच्छता",
        hygieneDesc = "बीमारियों से बचने के लिए शेड को साफ और सूखा रखें।",
        storage = "अनाज भंडारण",
        storageDesc = "चारे को नमी और कीटों से दूर सूखी जगह पर रखें।",
        watering = "पानी पिलाना",
        wateringDesc = "ताजे और साफ पीने के पानी तक 24/7 पहुंच सुनिश्चित करें।",
        impactGoal = "प्रभाव लक्ष्य",
        impactGoalDesc = "बेहतर आजीविका के लिए किसानों को वैज्ञानिक पोषण के साथ सशक्त बनाना।"
    ),
    AppLanguage.MR to AppStrings(
        title = "पशु आहार",
        subtitle = "निरोगी गुरांसाठी स्मार्ट पोषण",
        startBtn = "गणना सुरू करा",
        cow = "गाय",
        feed = "खाद्य",
        cost = "खर्च",
        tips = "ज्ञान केंद्र",
        breed = "जात",
        weight = "वजन (किलो)",
        age = "वय (वर्षे)",
        milkYield = "दूध उत्पादन (लिटर/दिवस)",
        generateRecipe = "रेसिपी तयार करा",
        recipeTitle = "पोषण रेसिपी",
        dailyRecipe = "दैनिक खाद्य मिश्रण",
        monthlySavings = "मासिक बचत",
        costComparison = "खर्च तुलना",
        homemade = "घरगुती खाद्य",
        market = "बाजारातील खाद्य",
        savings = "एकूण बचत",
        whyThisMix = "पशुवैद्यकीय ज्ञान आधार",
        backToHome = "मुख्यपृष्ठ",
        hygiene = "स्वच्छता",
        hygieneDesc = "आजार टाळण्यासाठी गोठा स्वच्छ आणि कोरडा ठेवा.",
        storage = "धान्य साठवणूक",
        storageDesc = "खाद्य ओलावा आणि कीटकांपासून दूर कोरड्या जागी साठवा.",
        watering = "पानी पिणे",
        wateringDesc = "ताजे आणि स्वच्छ पिण्याचे पाणी २४/७ उपलब्ध असल्याची खात्री करा.",
        impactGoal = "प्रभाव ध्येय",
        impactGoalDesc = "शेतकऱ्यांना वैज्ञानिक पोषणाद्वारे सक्षम करणे."
    )
)

val LocalLanguage = staticCompositionLocalOf { AppLanguage.EN }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var currentLang by remember { mutableStateOf(AppLanguage.EN) }
            CompositionLocalProvider(LocalLanguage provides currentLang) {
                PashuaaharTheme {
                    PashuAaharApp(onLanguageChange = { currentLang = it })
                }
            }
        }
    }
}

@Composable
fun PashuAaharApp(onLanguageChange: (AppLanguage) -> Unit) {
    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = "home",
            enterTransition = { fadeIn(animationSpec = tween(400)) },
            exitTransition = { fadeOut(animationSpec = tween(400)) }
        ) {
            composable("home") { HomeScreen(navController, onLanguageChange) }
            composable("profile") { CowProfileScreen(navController, onLanguageChange) }
            composable("tips") { TipsScreen(navController, onLanguageChange) }
            composable(
                "result/{breed}/{weight}/{milk}"
            ) { backStackEntry ->
                val breed = backStackEntry.arguments?.getString("breed") ?: ""
                val weight = backStackEntry.arguments?.getString("weight")?.toDoubleOrNull() ?: 0.0
                val milk = backStackEntry.arguments?.getString("milk")?.toDoubleOrNull() ?: 0.0
                ResultScreen(navController, breed, weight, milk, onLanguageChange)
            }
        }
    }
}

@Composable
fun LanguageActionIcon(onLanguageChange: (AppLanguage) -> Unit, tint: Color = Color.White) {
    var showMenu by remember { mutableStateOf(false) }
    Box {
        IconButton(onClick = { showMenu = true }) {
            Icon(Icons.Default.Language, contentDescription = "Language", tint = tint)
        }
        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
            DropdownMenuItem(text = { Text("English") }, onClick = { onLanguageChange(AppLanguage.EN); showMenu = false })
            DropdownMenuItem(text = { Text("हिंदी") }, onClick = { onLanguageChange(AppLanguage.HI); showMenu = false })
            DropdownMenuItem(text = { Text("मराठी") }, onClick = { onLanguageChange(AppLanguage.MR); showMenu = false })
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, onLanguageChange: (AppLanguage) -> Unit) {
    val s = translations[LocalLanguage.current]!!
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1B5E20), Color(0xFF4CAF50))
                )
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            LanguageActionIcon(onLanguageChange)
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Pets,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = s.title,
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )
        Text(
            text = s.subtitle,
            fontSize = 18.sp,
            color = Color.White.copy(alpha = 0.9f)
        )
        Spacer(modifier = Modifier.height(60.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                HomeIconItem(Icons.Default.Agriculture, s.cow) {
                    navController.navigate("profile")
                }
            }

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                HomeIconItem(Icons.Default.Restaurant, s.feed) {
                    navController.navigate("profile")
                }
            }

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                HomeIconItem(Icons.Default.Savings, s.cost) {
                    navController.navigate("profile")
                }
            }

            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                HomeIconItem(Icons.Default.Lightbulb, s.tips) {
                    navController.navigate("tips")
                }
            }
        }

        Spacer(modifier = Modifier.height(60.dp))
        
        Button(
            onClick = { navController.navigate("profile") },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(32.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)
        ) {
            Text(text = s.startBtn, color = Color(0xFF1B5E20), fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "📶 Works completely offline",
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 14.sp
        )
    }
}

@Composable
fun HomeIconItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(Color.White.copy(alpha = 0.25f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = label, tint = Color.White, modifier = Modifier.size(28.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CowProfileScreen(navController: NavHostController, onLanguageChange: (AppLanguage) -> Unit) {
    val s = translations[LocalLanguage.current]!!
    var breed by remember { mutableStateOf("Desi") }
    var weight by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var milkYield by remember { mutableFloatStateOf(10f) }
    
    val breeds = listOf("Desi", "Jersey", "Holstein")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(s.cow + " Profile", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = { LanguageActionIcon(onLanguageChange, tint = Color.Black) }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Text(s.breed, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    breeds.forEach { b ->
                        FilterChip(
                            selected = breed == b,
                            onClick = { breed = b },
                            label = { Text(b) },
                            shape = RoundedCornerShape(16.dp),
                            leadingIcon = if (breed == b) {
                                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(18.dp)) }
                            } else null
                        )
                    }
                }
            }

            item {
                Text("${s.milkYield}: ${milkYield.toInt()} L", fontWeight = FontWeight.Bold)
                Slider(
                    value = milkYield,
                    onValueChange = { milkYield = it },
                    valueRange = 0f..50f,
                    colors = SliderDefaults.colors(thumbColor = Color(0xFF1B5E20), activeTrackColor = Color(0xFF1B5E20))
                )
            }

            item { ProfileInputField(s.weight, weight, { weight = it }, "e.g. 450") }
            item { ProfileInputField(s.age, age, { age = it }, "e.g. 4") }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        if (weight.isNotEmpty()) {
                            navController.navigate("result/$breed/$weight/${milkYield.toInt()}")
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32))
                ) {
                    Text(s.generateRecipe, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ProfileInputField(label: String, value: String, onValueChange: (String) -> Unit, placeholder: String) {
    Column {
        Text(label, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(placeholder, color = Color.LightGray) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(navController: NavHostController, breed: String, weight: Double, milk: Double, onLanguageChange: (AppLanguage) -> Unit) {
    val s = translations[LocalLanguage.current]!!
    
    // Nutrition Logic: Based on milk yield and breed
    val breedFactor = when(breed) {
        "Jersey" -> 1.1
        "Holstein" -> 1.2
        else -> 1.0 // Desi
    }
    
    val maize = (milk * 0.45 * breedFactor + 1.2).coerceAtLeast(1.5)
    val oilCake = (milk * 0.25 * breedFactor + 0.6).coerceAtLeast(1.0)
    val roughage = (weight * 0.02).coerceAtLeast(10.0)
    
    val homemadeCost = (maize * 30 + oilCake * 45 + roughage * 3).toInt()
    val marketCost = (milk * 42 + 150).toInt()
    val dailySavings = marketCost - homemadeCost
    val monthlySavingsTotal = dailySavings * 30

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(s.recipeTitle, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = { LanguageActionIcon(onLanguageChange, tint = Color.Black) }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1B5E20)),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(s.monthlySavings, color = Color.White.copy(alpha = 0.8f), fontSize = 16.sp)
                        Text("₹$monthlySavingsTotal", color = Color.White, fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9)),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.RestaurantMenu, contentDescription = null, tint = Color(0xFF388E3C))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(s.dailyRecipe, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color(0xFF1B5E20))
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        RecipeLine("Maize (मका)", String.format("%.2f kg", maize), "Energy")
                        RecipeLine("Oil Cake (पेंड)", String.format("%.2f kg", oilCake), "Protein")
                        RecipeLine("Roughage (चारा)", String.format("%.1f kg", roughage), "Fiber")
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1)),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.AutoMirrored.Filled.TrendingUp, contentDescription = null, tint = Color(0xFFF57C00))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(s.costComparison, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = Color(0xFFE65100))
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        CostLine(s.homemade, "₹$homemadeCost")
                        CostLine(s.market, "₹$marketCost")
                        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = Color(0xFFFFE082))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(s.savings, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp)
                            Text("₹$dailySavings", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = Color(0xFF43A047))
                        }
                    }
                }
            }

            item {
                Button(
                    onClick = { navController.navigate("tips") },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32))
                ) {
                    Text(s.tips, color = Color.White, fontWeight = FontWeight.Bold)
                }
            }

            item {
                Button(
                    onClick = { navController.navigate("home") { popUpTo("home") { inclusive = true } } },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
                ) {
                    Text(s.backToHome, color = Color.DarkGray, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun RecipeLine(name: String, amount: String, category: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(category, fontSize = 12.sp, color = Color.Gray)
        }
        Text(amount, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = Color(0xFF2E7D32))
    }
}

@Composable
fun CostLine(label: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, fontSize = 16.sp)
        Text(value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipsScreen(navController: NavHostController, onLanguageChange: (AppLanguage) -> Unit) {
    val s = translations[LocalLanguage.current]!!
    val vKB = listOf(
        IngredientInfo(s.hygiene, "Health", s.hygieneDesc),
        IngredientInfo(s.storage, "Safety", s.storageDesc),
        IngredientInfo(s.watering, "Vital", s.wateringDesc)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(s.tips, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = { LanguageActionIcon(onLanguageChange, tint = Color.Black) }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(s.whyThisMix, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
                Spacer(modifier = Modifier.height(8.dp))
            }
            
            items(vKB) { tip ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(tip.name, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF2E7D32))
                        Text(tip.role, fontWeight = FontWeight.Medium, color = Color.Gray)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(tip.description)
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(s.impactGoal, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF1B5E20))
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(s.impactGoalDesc, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

data class IngredientInfo(val name: String, val role: String, val description: String)
