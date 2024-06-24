import SwiftUI
import shared
import KMPObservableViewModelSwiftUI
import SwiftUISnackbar

struct DatabaseScreen : View {
    
    @StateObject var viewModel = ViewModel()
    @State private var storedName: String = ""
    
    var body: some View {
        Group {
            VStack(alignment: .center) {
                Text("Please enter your name")
                TextField("Your name", text: $storedName)
                    .textFieldStyle(.roundedBorder)
                    .frame(width: 200)
                Spacer()
                Button("Store your name") {
                    viewModel.storeName(text: storedName)
                }.buttonStyle(.borderedProminent)
                    .padding(.top, 24)
                    .tint(.red)
            }
            .padding(.all, 24)
            .onReceive(viewModel.$databaseUiState) { state in
                switch state {
                case .idle:
                    storedName = ""
                case .data(let name):
                    storedName = name
                }
            }
        }.snackbar(isShowing: $viewModel.storeSuccess, title: "Name stored successfully", style: .custom(.black))
    }
    
    
}
