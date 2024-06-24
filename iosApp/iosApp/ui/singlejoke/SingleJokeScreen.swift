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
            switch singleJokeUiState {
            case is SingleJokeUiStateIdle:
                Text("Press the button and laugh :)")
            case is SingleJokeUiStateLoading:
                ProgressView()
            case let dataState as SingleJokeUiStateData:
                JokeTextView(joke: dataState.joke)
            default:
                Text("")
            }
        }
    }
}

#Preview {
    SingleJokeScreen()
}
