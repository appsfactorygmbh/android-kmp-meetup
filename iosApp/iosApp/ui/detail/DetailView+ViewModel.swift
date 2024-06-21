
import Foundation
import shared
import KMPNativeCoroutinesCombine
import Combine


extension DetailView {
    
    
    final class ViewModel : ObservableObject {

        let getJokesUseCase = koin.usecases.getJokesUseCase
        private var cancellables = Set<AnyCancellable>()

        @Published
        private(set) var jokeState: JokeState = .initialLoading
        
        init() {
            createPublisher(for: self.getJokesUseCase.invoke())
                .receive(on: DispatchQueue.main)
                .sink(
                    receiveCompletion: { _ in },
                    receiveValue: { [weak self] item in
                        self?.jokeState = .data(joke: item)
                    }
                ).store(in: &self.cancellables)
        }
    }
}

