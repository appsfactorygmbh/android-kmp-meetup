import SwiftUI
import shared
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI


struct MainView: View {
    
    @State var showSecondScreen = false
    @StateViewModel var viewModel = MainViewModel()
    
    var body: some View {
        NavigationStack {
            VStack(alignment: .center) {
                Text(Greeting().greet())
                Button("Request joke") {
                    viewModel.requestJoke()
                }.buttonStyle(.borderedProminent)
                    .padding(.top, 24)
                    .tint(.red)
                MainUiStateView(mainUiState: viewModel.menuUiState)
                    .padding(.top, 24)
                Button("Show next screen") {
                    showSecondScreen = true
                }.buttonStyle(.borderedProminent).tint(.red)
            }
            .navigationTitle("Joke App")
            .padding(24)
            .sheet(
                isPresented: $showSecondScreen,
                content: { DetailScreen() })
        
        }
    }
}


#Preview {
    MainView()
}
