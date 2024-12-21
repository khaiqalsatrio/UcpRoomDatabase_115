package com.example.ucp2_115.ui.navigation

interface AlamatNavigasi {
    val route: String
}

object DestinasiSplash : AlamatNavigasi {
    override val route = "splash"
}

object DestinasiDosen : AlamatNavigasi {
    override val route = "dosen"
}

object DestinasiDosenDetail : AlamatNavigasi {
    override val route = "dosendetail"
    const val NIDN = "nidn"
    val routesWithArg = "$route/{$NIDN}"
}

object DestinasiMatakuliahDetail : AlamatNavigasi {
    override val route = "matakuliah"
    const val KODE = "kode"
    val routesWithArg = "$route/{$KODE}"
}

object DestinasiMatakuliahUpdate : AlamatNavigasi {
    override val route = "matakuliahUpdate"
    const val KODE = "kode"
    val routesWithArg = "$route/{$KODE}"
}