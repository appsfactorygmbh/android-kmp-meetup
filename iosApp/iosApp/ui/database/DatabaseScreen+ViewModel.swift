import Foundation
import shared
import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesCombine
import Combine

extension DatabaseScreen {
    
    
    final class ViewModel : ObservableObject {
        
        let getNameUseCase = koin.usecases.getNameUseCase
        let storeNameUseCae = koin.usecases.storeNameUseCase
        private var cancellables = Set<AnyCancellable>()
        
        @Published
        private(set) var databaseUiState: DatabaseUiState = .idle
        
        @Published
        var storeSuccess = false
        
        init() {
            createPublisher(for: self.getNameUseCase.invoke())
                .receive(on: DispatchQueue.main)
                .sink(
                    receiveCompletion: { _ in },
                    receiveValue: { [weak self] name in
                        self?.databaseUiState = .data(name: name.text)
                    }
                ).store(in: &self.cancellables)
        }
        
        func storeName(text: String) {
            Task {
                await asyncResult(for: storeNameUseCae.invoke(name: Name(text: text)))
                storeSuccess = true
            }
        }
    }
}
