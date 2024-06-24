
import SwiftUI
import shared

struct JokesScreen : View {
    
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        switch self.viewModel.jokeUiState {
        case .loading:
            ProgressView()
        case .data(let joke):
            JokeTextView(joke: joke)
                .padding(.all, 24)
        }
    }
}


#Preview {
    JokesScreen()
}
