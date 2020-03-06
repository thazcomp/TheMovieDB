# TheMovieDB
Aplicativo Android feito com Android Studio, Kotlin e arquitetura MVVM.

# Descri��o
O aplicativo � respons�vel por exibir as informa��es da API MovieDB e organiz�-las entre:

- Em cartaz
- Populares
- Melhores Avaliados
- Em breve


Al�m disso permite a sele��o de um filme da lista para a exibi��o de maiores detalhes em uma activity separada.
O aplicativo foi constru�do visando demonstrar como funciona o mapeamento da API e a utiliza��o da arquitetura MVVM juntamente com Rx. Detalhes de Layout, margens e cores foram revisados, mas focados em segundo plano. Alguns cliques em bot�es n�o foram implementados, pois seriam s� repeti��o de trabalho e cria��o de views similares, o que n�o � o objetivo do desenvolvimento do aplicativo.

# Bibliotecas utilizadas
- Koin
- Retrofit
- RX (RxJava, RxKotlin, RxAndroid)
- Glide
- ColorRatingBar
- SmoothProgressBar

## Instala��o
Para executar o aplicativo basta abrir o projeto no Android Studio e clicar em 'Run' ou instalar diretamente no aparelho o APK dispon�vel na pasta app/release.


## ScreenShots
MainActivity| DetailActivity
:-- | :--
<img src="screenshots/Screenshot_1.png" width="260"> | <img src="screenshots/Screenshot_3.png" width="260">
<img src="screenshots/Screenshot_2.png" width="260"> | <img src="screenshots/Screenshot_4.png" width="260">