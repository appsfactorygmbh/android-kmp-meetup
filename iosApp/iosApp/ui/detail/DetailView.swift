
import SwiftUI
import shared

struct DetailView : View {
    
    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        switch self.viewModel.jokeState {
        case .initialLoading:
            ProgressView()
        case .data(let jokeResponse):
            JokeTextView(jokeResponse: jokeResponse)
                .padding(.all, 24)
        }
    }
}


#Preview {
    DetailView()
}
