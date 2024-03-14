package br.com.renancsdev.bancocarrefour.extension

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun Date.dataGMTParaPTBR(): String {
    val timeZone = Calendar.getInstance().timeZone.id
    var date = Date(this.time + TimeZone.getTimeZone(timeZone).getOffset(this.time))
    val formatoDestino = SimpleDateFormat("dd/MM/yyyy - hh:mm:ss", Locale("pt-br", "America/Sao_Paulo"))
    return formatoDestino.format(date)
}