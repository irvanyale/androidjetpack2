package app.irvanyale.com.academy.di;

import android.content.Context;

import app.irvanyale.com.academy.data.source.AcademyRepository;
import app.irvanyale.com.academy.data.source.remote.RemoteDataSource;
import app.irvanyale.com.academy.utils.JsonHelper;

public class Injection {

    public static AcademyRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return AcademyRepository.getInstance(remoteDataSource);
    }
}
