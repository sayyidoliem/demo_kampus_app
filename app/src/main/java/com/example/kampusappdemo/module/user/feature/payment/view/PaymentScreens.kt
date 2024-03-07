import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.kampusappdemo.module.user.feature.payment.component.BottomAppBarPaymentDemo
import com.example.kampusappdemo.module.user.feature.payment.component.CardPaymentMethodDemo
import com.example.kampusappdemo.module.user.feature.payment.component.ListItemPaymentDetailDemo
import com.example.kampusappdemo.module.user.feature.payment.component.ListItemPaymentDetailDescriptionDemo
import com.example.kampusappdemo.module.user.feature.payment.component.TopAppBarPaymentDemo
import com.example.kampusappdemo.module.user.feature.payment.viewmodel.PaymentViewModel

@Composable
fun PaymentScreens(
    modifier: Modifier,
    index: Int,
    viewModel: PaymentViewModel,
    navigateUp: () -> Unit
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val finalDataList = viewModel.dataAtIndex(context, index)
    finalDataList!!

    val total =  viewModel.getTotal(context, index)
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBarPaymentDemo(onClick = { navigateUp() })
        },
        bottomBar = {
            BottomAppBarPaymentDemo(totalPrice = total)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(scrollState)
        ) {
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

            ElevatedCard(modifier = Modifier.padding(16.dp)) {
                ListItemPaymentDetailDescriptionDemo(
                    title = finalDataList.name,
                    subTitle = "Name"
                )
                ListItemPaymentDetailDescriptionDemo(
                    title = finalDataList.studyProgram,
                    subTitle = "Study Program"
                )
                ListItemPaymentDetailDescriptionDemo(
                    title = "${finalDataList.location.district}, ${finalDataList.location.city}, ${finalDataList.location.province}",
                    subTitle = "Location"
                )
            }
            ElevatedCard(modifier = Modifier.padding(16.dp)) {
                ListItemPaymentDetailDemo(
                    title = "Registration",
                    subTitle = "Total",
                    trailingTitle = "Rp.${finalDataList.register}00"
                )
                ListItemPaymentDetailDemo(
                    title = "Visit",
                    subTitle = "Total",
                    trailingTitle = "Rp.${finalDataList.visit}00"
                )
                ListItemPaymentDetailDemo(
                    title = "Teleconsultation",
                    subTitle = "Total",
                    trailingTitle = "Rp.${finalDataList.teleConsultation}00"
                )
            }
        }
    }
}