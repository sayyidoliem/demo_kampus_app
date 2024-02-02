import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.feature.payment.viewmodel.PaymentViewModel
import com.example.kampusappdemo.feature.payment.component.BottomAppBarPaymentDemo
import com.example.kampusappdemo.feature.payment.component.CardPaymentMethodDemo
import com.example.kampusappdemo.feature.payment.component.ListItemPaymentDetailDemo
import com.example.kampusappdemo.feature.payment.component.TopAppBarPaymentDemo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreens(
    modifier: Modifier, nameUniversity: String,
    nameCity: String,
    imageUniversity: Int,
    typeUniversity: String,
    viewModel: PaymentViewModel,
    navigateUp: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarPaymentDemo(onClick = { navigateUp() })
        },
        bottomBar = {
            BottomAppBarPaymentDemo()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Payment Method",
                    style = MaterialTheme.typography.titleLarge
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Row {
                        Text(text = "All")
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "")
                    }
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                items(4) {
                    CardPaymentMethodDemo()
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "Payment Detail",
                style = MaterialTheme.typography.titleLarge
            )
            ListItemPaymentDetailDemo(
                title = nameUniversity,
                subTitle = "Name"
            )
            ListItemPaymentDetailDemo(
                title = typeUniversity,
                subTitle = "Type"
            )
            ListItemPaymentDetailDemo(
                title = "Universitas Coklat",
                subTitle = "Study Program"
            )
        }
    }
}