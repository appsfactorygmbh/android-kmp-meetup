import shared


func startKoin() {
    let koinApplication = Koin().doInitKoin()
    _koin = koinApplication.koin
}

private var _koin: Koin_coreKoin? = nil
var koin: Koin_coreKoin {
    return _koin!
}
