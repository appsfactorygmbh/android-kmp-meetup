
import SwiftUI
import shared

struct DetailView : View {
    
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        switch self.viewModel.jokeState {
        case .initialLoading:
            ProgressView()
        case .data(let joke):
            JokeTextView(joke: joke)
                .padding(.all, 24)
        }
    }
}


#Preview {
    DetailView()
}
