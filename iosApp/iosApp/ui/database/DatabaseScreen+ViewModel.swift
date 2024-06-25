import Foundation
import shared
import KMPNativeCoroutinesAsync
import KMPNativeCoroutinesCore
import KMPNativeCoroutinesCombine
import Combine

extension DatabaseScreen {
    
    
    final class ViewModel : ObservableObject {
        
        let getUserNameUseCase = koin.usecases.getUserNameUseCase
        let storeUserNameUseCase = koin.usecases.storeUserNameUseCase
        private var cancellables = Set<AnyCancellable>()
        
        @Published
        private(set) var databaseUiState: DatabaseUiState = .idle
        
        @Published
        var userNameStoredSuccessfully = false
        
        init() {
            createPublisher(for: getUserNameUseCase.invoke())
                .receive(on: DispatchQueue.main)
                .sink(
                    receiveCompletion: { _ in },
                    receiveValue: { [weak self] userName in
                        self?.databaseUiState = .data(name: userName.text)
                    }
                ).store(in: &cancellables)
        }
        
        @MainActor
        func storeUserName(userName: String) {
            Task {
                let result = await asyncResult(for: storeUserNameUseCase.invoke(userName: UserName(text: userName)))
        
                if case .success = result {
                    userNameStoredSuccessfully = true
                }
            }
        }
    }
}
