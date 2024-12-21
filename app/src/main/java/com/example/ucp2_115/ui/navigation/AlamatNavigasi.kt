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
    override val route = "dosen_detail"
    const val NIDN = "nidn"
    val routesWithArg = "$route/{$NIDN}" // Menggunakan placeholder untuk argumen
}

object DestinasiMatakuliah : AlamatNavigasi {
    override val route = "matakuliah"
}

object DestinasiMatakuliahDetail : AlamatNavigasi {
    override val route = "matakuliah_detail"
    const val KODE = "kode"
    val routesWithArg = "$route/{$KODE}" // Placeholder untuk argumen
}

object DestinasiMatakuliahUpdate : AlamatNavigasi {
    override val route = "matakuliah_update"
    const val KODE = "kode"
    val routesWithArg = "$route/{$KODE}" // Placeholder untuk argumen
}
