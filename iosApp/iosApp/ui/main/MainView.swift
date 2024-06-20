import SwiftUI
import shared
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI


struct MainView: View {
    
    var body: some View {
        NavigationView {
            OverviewView()
            DetailView()
        }
    }
}


#Preview {
    MainView()
}
