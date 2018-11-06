package br.com.paulosalvatore.ocean_a6_06_11_18

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.paulosalvatore.ocean_a6_06_11_18.api.GithubRepositoriesResult
import br.com.paulosalvatore.ocean_a6_06_11_18.api.RepositoryRetriever
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val repositoryRetriever = RepositoryRetriever()

    private val callback = object : Callback<GithubRepositoriesResult> {
        override fun onFailure(call: Call<GithubRepositoriesResult>, t: Throwable) {
            Toast.makeText(
                this@MainActivity,
                "Fail loading repositories",
                Toast.LENGTH_LONG
            ).show()
        }

        override fun onResponse(call: Call<GithubRepositoriesResult>, response: Response<GithubRepositoriesResult>) {
            Toast.makeText(
                this@MainActivity,
                "Load finished.",
                Toast.LENGTH_LONG
            ).show()

            response.isSuccessful.let {
                response.body()?.repositories?.let { repositories ->
                    textView.text = ""
                    repositories.forEach { repository ->
                        textView.append("${repository.full_name}\n")
                    }
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repositoryRetriever.getLanguageRepositories(callback, "kotlin")
    }
}
