import SwiftUI
import shared
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI


struct OverviewView: View {
    
    @StateViewModel var viewModel: OverviewViewModel = OverviewViewModel(
        getJokeUseCase: koin.usecases.getJokeUseCase
    )
    
    var body: some View {
        VStack(alignment: .center) {
            Text(Greeting().greet())
            Button("Request joke") {
                viewModel.requestJoke()
            }.buttonStyle(.borderedProminent)
                .padding(.top, 24)
                .tint(.red)
            Spacer()
            JokeView(jokeUiState: viewModel.jokeUiState)
            Spacer()
            NavigationLink("Show DetailView") {
                DetailView()
            }.buttonStyle(.borderedProminent).tint(.red)
        }
        .navigationTitle("Joke App")
        .padding(24)
    }
}

#Preview {
    OverviewView()
}
