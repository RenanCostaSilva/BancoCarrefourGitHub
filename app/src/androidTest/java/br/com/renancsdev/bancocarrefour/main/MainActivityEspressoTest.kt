package br.com.renancsdev.bancocarrefour.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.renancsdev.bancocarrefour.R
import br.com.renancsdev.bancocarrefour.ui.activity.main.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @Test
    @Ignore(" Sem necessicade para testar ")
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("br.com.renancsdev.sky", appContext.packageName)
    }

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // Recyclerview
    @Test
    fun testeListaTemInteracao(){

        Thread.sleep(5000)
        onView(withId(R.id.rv_carrefour_usuarios)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,click())
        )
    }
    @Test
    fun testeListaExibeDadosCorretosEredirecinaParaDetalhes(){

        Thread.sleep(5000)
        onView(withId(R.id.rv_carrefour_usuarios)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.imv_usuario_github))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withText(R.string.label_lista_usuario_login)).check(ViewAssertions.doesNotExist())
    }


    // Detalhe
    @Test
    fun testeDetalhesDoUsuarioForamCarregados(){


        Thread.sleep(5000)
        onView(withId(R.id.rv_carrefour_usuarios)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.imv_usuario_github))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withText(R.id.tv_data_criacao_usuario_github)).check(
            ViewAssertions.doesNotExist())

        onView(withId(R.id.tv_empresa_usuario_github)).check(
            ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))

        onView(withId(R.id.tv_nome_usuario_github)).check(
            ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))

        onView(withId(R.id.tv_git_usuario_github)).check(
            ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(""))))

    }

    @Test
    fun testeRedirecionamentoPorBotaoParaTelaRepositorios(){

        Thread.sleep(5000)
        onView(withId(R.id.rv_carrefour_usuarios)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.btn_detalhe_usuario_repositorio)).perform(click())

    }

}