import SwiftUI
import shared
import KMPObservableViewModelSwiftUI
import SwiftUISnackbar

struct DatabaseScreen : View {
    
    @StateObject var viewModel = ViewModel()
    @State private var userName: String = ""
    
    var body: some View {
        Group {
            VStack(alignment: .center) {
                Text("Please enter your username")
                TextField("Your username", text: $userName)
                    .textFieldStyle(.roundedBorder)
                    .frame(width: 200)
                Spacer()
                Button("Store your username") {
                    userName = userName.trimmingCharacters(in: .whitespacesAndNewlines)
                    viewModel.storeUserName(userName: userName)
                }.buttonStyle(.borderedProminent)
                    .padding(.top, 24)
                    .tint(.red)
            }
            .padding(.all, 24)
            .onReceive(viewModel.$databaseUiState) { state in
                switch state {
                case .idle:
                    userName = ""
                case .data(let name):
                    userName = name
                }
            }
        }.snackbar(
            isShowing: $viewModel.userNameStoredSuccessfully,
            title: userName.isEmpty ? "Username cleared successfully" :
                "Username (\(userName)) stored successfully",
            style: .custom(.black)
        )
    }
    
    
}
