
import Foundation
import shared
import KMPNativeCoroutinesCombine
import Combine


extension JokesScreen {
    
    
    final class ViewModel : ObservableObject {

        let getJokesUseCase = koin.usecases.getJokesUseCase
        private var cancellables = Set<AnyCancellable>()

        @Published
        private(set) var jokeUiState: JokeUiState = .loading
        
        init() {
            createPublisher(for: self.getJokesUseCase.invoke())
                .receive(on: DispatchQueue.main)
                .sink(
                    receiveCompletion: { _ in },
                    receiveValue: { [weak self] item in
                        self?.jokeUiState = .data(joke: item)
                    }
                ).store(in: &self.cancellables)
        }
    }
}

