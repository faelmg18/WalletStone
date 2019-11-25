package br.com.rafaelhfernandes.splashscreen.dependeciesinjections



/*

@Module
class RoomModule {
    private var walletStoneDataBase: WalletStoneDataBase =
        Room.databaseBuilder(
            WalletStoneApplication.appContext,
            WalletStoneDataBase::class.java,
            DATA_BASE_NAME
        )
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): WalletStoneDataBase {
        return walletStoneDataBase
    }

    @Singleton
    @Provides
    fun providePriceDao(walletStoneDataBase: WalletStoneDataBase): PriceDao {
        return walletStoneDataBase.priceDao
    }

    @Singleton
    @Provides
    fun priceDataSource(priceDao: PriceDao): PriceDataSource {
        return PriceDataSourceImpl(priceDao)
    }

    @Provides
    fun provideGetDollar(
        priceRepository: PriceRepository
    ): GetDollarPrice {
        return GetDollarPrice(priceRepository)
    }

    @Provides
    fun providePriceViewModelFactory(
        getDollarPrice: GetDollarPrice,
        priceDataSource: PriceDataSource

    ) = PriceViewModel.Factory(getDollarPrice, priceDataSource)
}*/
