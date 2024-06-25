import SwiftUI
import shared
import KMPObservableViewModelSwiftUI

struct SingleJokeScreen : View {
    
    @StateViewModel var viewModel = SingleJokeViewModel(
        getJokeUseCase: koin.usecases.getJokeUseCase
    )
    var body: some View {
        Group {
            Spacer()
            JokeView(singleJokeUiState: viewModel.singleJokeUiState)
            Spacer()
            Button("Request joke") {
                viewModel.requestJoke()
            }.buttonStyle(.borderedProminent)
                .padding(.top, 24)
                .tint(.red)
                .disabled(viewModel.singleJokeUiState is SingleJokeUiStateLoading)
        }.padding(.all, 24)
    }
}

struct JokeView: View {
    var singleJokeUiState: SingleJokeUiState
    
    init(singleJokeUiState: SingleJokeUiState) {
        self.singleJokeUiState = singleJokeUiState
    }
    
    var body: some View {
        Group {
            switch onEnum(of: singleJokeUiState) {
            case .idle:
                Text("Press the button and laugh :)")
            case .loading:
                ProgressView()
            case .data(let data):
                JokeTextView(joke: data.joke)
            }
        }
    }
}

#Preview {
    SingleJokeScreen()
}
