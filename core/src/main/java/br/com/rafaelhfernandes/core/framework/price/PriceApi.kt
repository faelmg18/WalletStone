package br.com.rafaelhfernandes.core.framework.price

import br.com.rafaelhfernandes.core.domain.entities.Price
import br.com.rafaelhfernandes.core.framework.model.BaseResponse
import retrofit2.http.GET

const val DATA_COTACAO = "CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='11-22-2019'&'$'" +
        "top=100&'$'skip=0&'$'format=json"

interface PriceApi {
    @GET(DATA_COTACAO)
    suspend fun getDollarPriceToday(): BaseResponse<Price>
}

/*const val tt =
    "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao=11-22-2019'&'$'top=100&'$'format=json"

interface PriceApi {
    @GET(tt)
    suspend fun getDollarPriceToday(@Query("dataCotacao") dataCotacao: String): BaseResponse<Price>
}*/
