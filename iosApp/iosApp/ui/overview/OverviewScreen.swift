import SwiftUI
import shared


struct OverviewScreen: View {
    
    
    var body: some View {
        NavigationView {
            VStack(alignment: .center) {
                Spacer()
                Text(Greeting().greet())
                Spacer()
                NavigationLink("Open single joke") {
                    SingleJokeScreen()
                }.buttonStyle(.borderedProminent).tint(.red)
                NavigationLink("Open jokes") {
                    JokesScreen()
                }.buttonStyle(.borderedProminent).tint(.red)
                NavigationLink("Open database example") {
                    DatabaseScreen()
                }.buttonStyle(.borderedProminent).tint(.red)
            }
            .navigationTitle("Joke App")
            .padding(24)
        }
    }
}

#Preview {
    OverviewScreen()
}
