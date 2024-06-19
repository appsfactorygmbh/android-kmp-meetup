
import SwiftUI
import shared

struct DetailScreen : View {
    
    let platform : Platform = koin.platform
    var body: some View {
        Text(platform.name)
    }
}


#Preview {
    DetailScreen()
}
