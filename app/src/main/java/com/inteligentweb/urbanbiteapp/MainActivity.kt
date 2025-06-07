package com.inteligentweb.urbanbiteapp

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.inteligentweb.urbanbiteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1) Infla el layout principal con ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2) Configura la Toolbar
        setSupportActionBar(binding.appBarMain.toolbar)

        // 3) (Opcional) Configura el FAB si lo usaras
        // binding.appBarMain.fab.setOnClickListener { view ->
        //     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //         .setAction("Action", null)
        //         .setAnchorView(R.id.fab)
        //         .show()
        // }

        // 4) Obtiene referencias al DrawerLayout y al NavigationView (menú lateral)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        // 5) Obtiene el NavController desde el NavHostFragment (en content_main.xml)
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // 6) Indica qué IDs son destinos “top-level” (mostrarán la hamburguesa en la Toolbar):
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_orders,
                R.id.nav_favorites,
                R.id.nav_configuracion,
                R.id.nav_ayuda
            ),
            drawerLayout
        )

        // 7) Vincula la Toolbar con NavController y AppBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // 8) Conecta el NavigationView (drawer) con el NavController
        navView.setupWithNavController(navController)

        // 9) Obtiene la referencia al BottomNavigationView (ya está declarado en app_bar_main.xml)
        val bottomNavView: BottomNavigationView = binding.appBarMain.bottomNavView

        // 10) Conecta el BottomNavigationView con el NavController para que navegue e ilumine el ícono activo
        bottomNavView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar el menú de opciones (si lo necesitas)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        // Gestiona la acción “Up” (flecha en la Toolbar)
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
