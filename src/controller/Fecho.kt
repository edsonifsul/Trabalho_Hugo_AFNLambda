package controller

import model.Afd
import model.Afnl
import model.FechoModel

class Fecho {
    fun fechoLambda(afd: Afnl): FechoModel {
        val fecho = mutableListOf<FechoModel>()
        var aux = FechoModel()

        afd.transicoes.forEach {
            if (it.entrada == "lambda") {
                if (fecho.isEmpty()) {
                    aux.estado = it.inicial
                    aux.entrada = it.entrada
                    aux.fecho = it.final
                    fecho.add(aux)
                } else {
                    for (f in fecho) {
                        if (f.estado == it.inicial) {
                            if (!f.fecho.contains(it.final)) {
                                f.fecho = f.fecho + it.final
                            }
                        } else {
                            aux.estado = it.inicial
                            aux.entrada = it.entrada
                            aux.fecho = it.final
                            fecho.add(aux)
                        }
                    }
                }

            }
        }
        fecho.forEach {
            for (fim in afd.fim){
                if (it.fecho.contains(fim)) aux.f.add(it.estado)
            }
            print(it.estado)
            print(" ${it.entrada} ")
            println(it.fecho)

        }
        return aux
    }
}